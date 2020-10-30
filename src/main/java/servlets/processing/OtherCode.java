package servlets.processing;

import models.ImgAlbum;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import stores.ImgAlbumStore;
import util.CustomLog;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.List;


public class OtherCode {

    public static void getImgAlbumById(HttpServletRequest req,
                                       HttpServletResponse resp, HttpServlet servlet) {
        System.out.println("Print something!");
    }

    public static void saveImgAlbum(HttpServletRequest req,
                                    HttpServletResponse resp, HttpServlet servlet) {

        try {
            String description = req.getParameter("description"); // Retrieves <input type="text" name="description">

            Part filePart = req.getPart("file"); // Retrieves <input type="file" name="file">
            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.

            try (InputStream fileContent = filePart.getInputStream()) {
                ImgAlbum album = new ImgAlbum(0, List.of(fileContent.readAllBytes()));
                ImgAlbumStore.instOf().add(album);


            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }

        // ... (do your job here)


    }

    private static void loadImg(HttpServletRequest req, HttpServlet servlet) {
        CustomLog.log("saveImg");
//        CustomLog.log("img", );
        try {
            ImgAlbum rsl = new ImgAlbum();
            for (FileItem item : createDefaultFactory(servlet).parseRequest(req)) {
                if (!item.isFormField()) {
                    rsl.addImg(item.getInputStream().readAllBytes());
                }
            }
            ImgAlbumStore.instOf().add(rsl);
        } catch (FileUploadException | IOException e) {
            e.printStackTrace();
        }
    }


    private static ServletFileUpload createDefaultFactory(HttpServlet servlet) {
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletContext servletContext = servlet.getServletConfig().getServletContext();
        File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
        factory.setRepository(repository);
        return new ServletFileUpload(factory);
    }

}
