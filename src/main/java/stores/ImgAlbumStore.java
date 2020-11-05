package stores;

import hibernate.HbmCoreStoreApi;
import models.ImgAlbum;

import java.util.List;

public class ImgAlbumStore {
    private static class LazyHolder {
        static final ImgAlbumStore INSTANCE = new ImgAlbumStore();
    }
    public static ImgAlbumStore instOf() {
        return ImgAlbumStore.LazyHolder.INSTANCE;
    }

    /* Class description */
    private final HbmCoreStoreApi<ImgAlbum> core = new HbmCoreStoreApi<>("ImgAlbum");

    public void add(ImgAlbum imgAlbum) {
        core.add(imgAlbum);
    }

    public ImgAlbum getById(int id) {
        var temp = core.getBy("id", id);
        return getImgAlbumOrEmptyUser(temp);
    }

    public ImgAlbum getByName(String name) {
        var temp = core.getBy("name", name);
        return getImgAlbumOrEmptyUser(temp);
    }

    public void delete(int id) {
        core.delete(id);
    }

    private ImgAlbum getImgAlbumOrEmptyUser(List<ImgAlbum> list) {
        return (list.isEmpty()) ? new ImgAlbum() : list.get(0);
    }

}
