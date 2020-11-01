package models.views;

import models.ImgAlbum;

import javax.xml.bind.DatatypeConverter;

import static util.JsonCollector.collect;
import static util.JsonCollector.wrapObject;

/**
 * Standard: encoding bytes to Base64.
 */
public class ImgAlbumView {

    /**
     *
     * @param album model for prepare to front.
     * @return (String) json obj:
     * {
     *     "imgBase64":Sting(byte[] - encoded into Base64)
     * }
     */
    public static String jsonMapFirstImg(ImgAlbum album) {
        String imgBase64 = "";
        var tempList = album.getImgList();
        if (!tempList.isEmpty()) {
            imgBase64 = DatatypeConverter.printBase64Binary(tempList.get(0));
        }

        return wrapObject(collect("imgBase64", imgBase64));
    }
}
