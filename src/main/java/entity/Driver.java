package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Scanner;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Driver implements Serializable {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "driver5_seq")
    @SequenceGenerator(name = "driver5_seq", sequenceName = "driver5_seq", allocationSize = 1, initialValue = 10000)
    private int id;

    @Column(name = "fullname")
    private String fullName;

    private String address;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "drive_level")
    private String driveLevel;

    public void inputInfo() {
        System.out.print("Nhập tên lái xe: ");
        this.fullName = new Scanner(System.in).nextLine();
        System.out.print("Nhập tên địa chỉ: ");
        this.address = new Scanner(System.in).nextLine();
        intputPhoneNumber();
        inputDriveLevel();
    }

    public void intputPhoneNumber() {
        System.out.print("Nhập số điện thoại: ");
        String phoneNumber = "";
        do {
            phoneNumber = new Scanner(System.in).nextLine();
            if (phoneNumber.matches("\\d+")) {
                this.phoneNumber = phoneNumber;
                break;
            }
            System.out.println("Số điện thoại chỉ nhập số !");
        } while (true);
    }

    public void inputDriveLevel() {
        System.out.print("Nhập trình độ (A-F): ");
        String driveLevel = "";
        do {
            driveLevel = new Scanner(System.in).nextLine();
            if (driveLevel.matches("[a-fA-F]")) {
                this.driveLevel = driveLevel;
                break;
            }
            System.out.println("trình độ phải A-F !");
        } while (true);
    }
}