package util;

import stores.OrderStore;

/**
 * manual tool - not for production.
 */
public class ManualExperiment {

    public static void main(String[] args) {
//        var art = new File("C:/Users/Admin/Desktop/anime_devushki_bosye_6_18092134.png");
//        var copyPath = "C:/Users/Admin/Desktop/tryCopy.png";
//        var temp = bytes(art);
//        var rsl = bytesToFile(copyPath, temp);
//        CustomLog.log("rsl", rsl);
//        CustomLog.log("rsl name", rsl.getName());
//        CustomLog.log("rsl abs path", rsl.getAbsolutePath());


//        String json = "{\"menu\": {\n" +
//                "  \"id\": \"file\",\n" +
//                "  \"value\": \"File\",\n" +
//                "  \"popup\": {\n" +
//                "    \"menuitem\": [\n" +
//                "      {\"value\": \"New\", \"onclick\": \"CreateNewDoc()\"},\n" +
//                "      {\"value\": \"Open\", \"onclick\": \"OpenDoc()\"},\n" +
//                "      {\"value\": \"Close\", \"onclick\": \"CloseDoc()\"}\n" +
//                "    ]\n" +
//                "  }\n" +
//                "}}";
//
//        byte[] bytes = json.getBytes();
//
//        String base64Encoded = DatatypeConverter.printBase64Binary(bytes);
//        System.out.println("Encoded Json:\n");
//        System.out.println(base64Encoded + "\n");
//
//        byte[] base64Decoded = DatatypeConverter.parseBase64Binary(base64Encoded);
//        System.out.println("Decoded Json:\n");
//        System.out.println(new String(base64Decoded));



//        var list = OrderStore.instOf().getAll();
//
//        for (var each : list) {
//            System.out.println("sout: " + each.getImgAlbum().getImgList());
//        }

        System.out.println(OrderStore.instOf().getById(1));

    }




//    private ServletFileUpload createDefaultFactory() {
//        DiskFileItemFactory factory = new DiskFileItemFactory();
//        ServletContext servletContext = this.getServletConfig().getServletContext();
//        File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
//        factory.setRepository(repository);
//        return new ServletFileUpload(factory);
//    }
//
//    private int loadImg(HttpServletRequest req, ServletFileUpload upload)
//            throws IOException {
//        int rsl = -1;
//        try {
//            List<FileItem> items = upload.parseRequest(req);
//            for (FileItem item : items) {
//                if (!item.isFormField()) {
//                    rsl = PsqlStoreImg.instOf().toBaseFile(item.getInputStream().readAllBytes());
//                }
//            }
//        } catch (FileUploadException e) {
//            e.printStackTrace();
//        }
//        return rsl;
//    }


}
