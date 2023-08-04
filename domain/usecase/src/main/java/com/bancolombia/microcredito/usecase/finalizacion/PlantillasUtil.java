package com.bancolombia.microcredito.usecase.finalizacion;

import com.bancolombia.microcredito.domain.constantes.CodigosRespuestaFNG;
import com.bancolombia.microcredito.domain.constantes.ConstantesFNG;
import com.bancolombia.microcredito.domain.error.ErrorRequestDTO;
import com.bancolombia.microcredito.domain.exception.FNGFailException;
import com.bancolombia.microcredito.domain.log.gateways.LoggerRepository;
import com.bancolombia.microcredito.domain.parametro.Parametro;
import com.bancolombia.microcredito.domain.respuestadescarga.RespuestaDescarga;
import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import java.io.File;
import java.io.FileOutputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.*;

public class PlantillasUtil {

    private List<Parametro> listaParametros = new ArrayList<Parametro>();
    private String rutaPlantilla = null;
    private String plantilla = null;
    private VelocityEngine velocityEngine = null;
    private VelocityContext context = null;
    private Template template = null;
    private StringWriter writer = null;
    private String imagenes[] = null;
    private File filePdf;
    private RespuestaDescarga respuestaDescarga;

    private final LoggerRepository log;




    public PlantillasUtil(List<Parametro> listaParametros, LoggerRepository logger) {

        this.listaParametros = listaParametros;
        respuestaDescarga = new RespuestaDescarga();
        respuestaDescarga.setEstadoRespuesta(true);
        log = logger;
    }

    /***
     * procedimiento que se encarga de convertir la plantilla html en un archivo PDF
     *
     *1
     */
    public void createFile(ErrorRequestDTO infoError) {

        filePdf = null;
        Path file = null;
        Document document = new Document();
        PdfWriter pdfWriter = null;

        try{

            FileAttribute<Set<PosixFilePermission>> attributes
                    = PosixFilePermissions.asFileAttribute(new HashSet<>(
                    Arrays.asList(PosixFilePermission.OWNER_WRITE,
                            PosixFilePermission.OWNER_READ)));
            file = Files.createTempFile("tmp", ".".concat("pdf"), attributes);



            document.setPageSize(PageSize.LETTER);
            filePdf=file.toFile();

            pdfWriter = PdfWriter.getInstance(document,new FileOutputStream(filePdf.getPath()));

            document.open();

            createBodyHtml();


            if (respuestaDescarga.isEstadoRespuesta()){
                String content = this.writer.toString();

                XMLWorkerHelper.getInstance().parseXHtml(pdfWriter, document,new StringReader(content));

                document.close();

                pdfWriter.close();
                log.info("PDF generated successfully");

                System.out.println("PDF generated successfully");

                System.out.println(filePdf.getPath());
            } else{
                throw new FNGFailException(respuestaDescarga.getCodigo(), respuestaDescarga.getDescripcion(), infoError.getIdSesion(), infoError.getPasoFuncional());
            }



        } catch (Exception e){
            log.error("Error  exception: " + e.getMessage());
            respuestaDescarga.setError(CodigosRespuestaFNG.DDOC_003.getCodigo(),
                    CodigosRespuestaFNG.DDOC_003.getDescripcion());
        }

    }

    /***
     * Procedimiento que mapea los parametros recibidos y crea el cuerpo html del plan de amortizacion
     * @return
     */
    public boolean createBodyHtml() {

        writer = new StringWriter();

        try {


            if(!plantilla.equals(""))
                log.info("Nombre de plantilla de plan de amortización: " + plantilla);
            else {
                respuestaDescarga.setError(CodigosRespuestaFNG.ERROR_NOMBRE_PLANTILLA.getCodigo(), CodigosRespuestaFNG.ERROR_NOMBRE_PLANTILLA.getDescripcion());
                return false;
            }


            if(!rutaPlantilla.equals(""))
                log.info("Ruta de plantilla del plan de amortización: " + rutaPlantilla);
            else {
                respuestaDescarga.setError(CodigosRespuestaFNG.ERROR_RUTA_PLANTILLA.getCodigo(), CodigosRespuestaFNG.ERROR_RUTA_PLANTILLA.getDescripcion());
                return false;
            }

            context = new VelocityContext();

            for (Parametro param : listaParametros) {

                context.put(param.getKey(), param.getValue());

                if (param.getKey().equals(ConstantesFNG.IMAGENES)) {
                    log.info("loggeando imágenes");
                    imagenes = param.getValue().split(",");
                    log.info("imagenes: " + imagenes);
                }

            }

            velocityEngine = new VelocityEngine();

            try {
                template = velocityEngine.getTemplate(plantilla);
            } catch (Exception e) {
                log.error("Error exception: " + e.getMessage(), e);
                respuestaDescarga.setError(CodigosRespuestaFNG.DDOC_002.getCodigo(),
                        CodigosRespuestaFNG.DDOC_002.getDescripcion() + ": " + plantilla);
                return false;
            }

            template.merge(context, writer);

            return true;

        } catch (Exception e) {
            log.error("Error  exception: " + e.getMessage(), e);
            respuestaDescarga.setError(CodigosRespuestaFNG.DDOC_005.getCodigo(),
                    plantilla + " -> " + CodigosRespuestaFNG.DDOC_005.getDescripcion());

            return false;
        }

    }

    public void setRutaPlantilla(String path){
        this.rutaPlantilla = path;
    }

    public void setPlantilla(String nombrePlantilla){
        this.plantilla = nombrePlantilla;
    }

    public File getFilePdf() {
        return this.filePdf;
    }

 


}
