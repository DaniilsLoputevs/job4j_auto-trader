package models;


import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

@Entity
@Table(name = "img_albums")
public class ImgAlbum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ElementCollection(targetClass = byte[].class, fetch = FetchType.EAGER)
    private List<byte[]> imgList;

    public ImgAlbum() {
    }

    public ImgAlbum(int id, List<byte[]> imgList) {
        this.id = id;
        this.imgList = imgList;
    }

    public void addImg(byte[] img) {
        this.imgList.add(img);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<byte[]> getImgList() {
        return imgList;
    }

    public void setImgList(List<byte[]> imgList) {
        this.imgList = imgList;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        ImgAlbum album = (ImgAlbum) object;
        return id == album.id
                && Objects.equals(imgList, album.imgList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, imgList);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ImgAlbum.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("imgList=" + imgList)
                .toString();
    }
}
