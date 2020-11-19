package models;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.StringJoiner;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @JoinColumn(name = "img_album_id")
    private ImgAlbum imgAlbum;
    private String description;
    private int price;

    @ManyToOne(cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @JoinColumn(name = "car_id", unique = true)
    private Car car;

    private String area;
    @ManyToOne(cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @JoinColumn(name = "user_id")
    private User seller;
    private boolean isSold;

    @Temporal(value = TemporalType.DATE)
    private Date created;

    public Order() {
    }

//    public Order(int id, ImgAlbum imgAlbum,
//                 String description, int price, Car car,
//                 String area, User seller, boolean isSold) {
//        this.id = id;
//        this.imgAlbum = imgAlbum;
//        this.description = description;
//        this.price = price;
//        this.car = car;
//        this.area = area;
//        this.seller = seller;
//        this.isSold = isSold;
//    }

    public Order(int id, ImgAlbum imgAlbum,
                 String description, int price, Car car,
                 String area, User seller, boolean isSold,
                 Date created) {
        this.id = id;
        this.imgAlbum = imgAlbum;
        this.description = description;
        this.price = price;
        this.car = car;
        this.area = area;
        this.seller = seller;
        this.isSold = isSold;
        this.created = created;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ImgAlbum getImgAlbum() {
        return imgAlbum;
    }

    public void setImgAlbum(ImgAlbum imgAlbum) {
        this.imgAlbum = imgAlbum;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    public boolean isSold() {
        return isSold;
    }

    public void setSold(boolean sold) {
        isSold = sold;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Order order = (Order) object;
        return id == order.id
                && price == order.price
                && isSold == order.isSold
                && Objects.equals(imgAlbum, order.imgAlbum)
                && Objects.equals(description, order.description)
                && Objects.equals(car, order.car)
                && Objects.equals(area, order.area)
                && Objects.equals(seller, order.seller);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, imgAlbum, description, price, car, area, seller, isSold);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Order.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("imgAlbum=" + imgAlbum)
                .add("desc='" + description + "'")
                .add("price=" + price)
                .add("car=" + car)
                .add("area='" + area + "'")
                .add("seller=" + seller)
                .add("isSold=" + isSold)
                .toString();
    }

}
