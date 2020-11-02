package util;

import java.util.function.Consumer;
import java.util.function.Supplier;

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

//        System.out.println(OrderStore.instOf().getById(1));


//        var user = UserStore.instOf().getByName("root");
//        CustomLog.log("user", user);
//        CustomLog.log("view", UserView.jsonMapOnlyName(user));

//        var listAll = OrderStore.instOf().getById(2);
//        var rsl = ViewJsonMapper.ordersForIndexTable(listAll);
//        CustomLog.log("rsl", listAll);




//        new Time(2 + 1 + 1 + 2,
//                20 + 30 + 30 + 30).showSumTime();

//        1  nov - session 12 : 11:00 - 13:20 (2:20)
//        1  nov - session 13 : 14:00 - 15:30 (1:30)
//        1  nov - session 14 : 17:20 - 18:50 (1:30)
//        1  nov - session 14 : 19:40 - 22:10 (2:30)




        var model = new Model();
        CustomLog.log("init", model.getName());
        updFieldIfNotEqual(model::getName, "newName", model::setName);
        CustomLog.log("upd", model.getName());



    }

    /**
     * short fort for upd field of object.
     *
     * @param getter - method reference. Example: obj::getName
     * @param newVal - value that set if not equal.
     * @param setter - method reference. Example: obj::setName
     */
    private static void updFieldIfNotEqual(Supplier<String> getter, String newVal, Consumer<String> setter) {
        String oldVal = getter.get();
        if (oldVal != null) {
            if (!getter.get().equals(newVal)) {
                setter.accept(newVal);
            }
        } else {
            setter.accept(newVal);
        }
    }

    static class Model {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }


    static class Time {
        int hours;
        int mins;

        public Time(int hours, int mins) {
            this.hours = hours;
            this.mins = mins;
        }

        public void showSumTime() {
            int totalMin = (hours * 60) + mins;
            int finalHours = totalMin / 60;
            int finalMin = totalMin % 60;

            System.out.println("Hours: " + finalHours);
            System.out.println("Min: " + finalMin);

        }
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
