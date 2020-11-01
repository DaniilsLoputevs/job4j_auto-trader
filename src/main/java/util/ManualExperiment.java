package util;

import stores.OrderStore;

import java.util.StringJoiner;

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

        var listAll = OrderStore.instOf().getById(2);
//        var rsl = ViewJsonMapper.ordersForIndexTable(listAll);
        CustomLog.log("rsl", listAll);





//        var model = new Model(0, "model");
//        var dto = DtoModel.of(model);
//
//        var container = new Container(dto);
//
//        System.out.println(container.getModel().getId());
//
//        System.out.println(container);
    }
    static class Container {
        private Model model;

        public Container(Model model) {
            this.model = model;
        }

        public Model getModel() {
            return model;
        }

        public void setModel(Model model) {
            this.model = model;
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", Container.class.getSimpleName() + "[", "]")
                    .add("model=" + model)
                    .toString();
        }
    }

    static class Model {
        private int id;
        private String name;

        public Model(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", Model.class.getSimpleName() + "[", "]")
                    .add("id=" + id)
                    .add("name='" + name + "'")
                    .toString();
        }
    }

    static class DtoModel extends Model{
        private String name;


        public DtoModel(int id, String name, String name1) {
            super(id, name);
            this.name = name1;
        }

        //        public DtoModel(String name) {
//            this.name = name;
//        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public static DtoModel of(Model model) {
            DtoModel dto = new DtoModel(-1, null, null);
            dto.setName(model.name);
            return dto;
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", DtoModel.class.getSimpleName() + "[", "]")
                    .add("name='" + name + "'")
                    .toString();
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
