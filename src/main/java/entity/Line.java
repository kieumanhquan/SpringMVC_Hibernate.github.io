package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Line implements Serializable {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "line5_seq")
    @SequenceGenerator(name = "line5_seq", sequenceName = "line5_seq", allocationSize = 1, initialValue = 100)
    private int id;

    private float distance;

    @Column(name = "stop_point")
    private int stopPoint;

    public void inputInfo() {
        intputDistance();
        intputStopPoint();
    }

    public void intputDistance(){
        System.out.print("Nhập Khoảng cách: ");
        float tempDistance = -1;
        do {
            try {
                tempDistance = new Scanner(System.in).nextFloat();
                if (tempDistance > 0) {
                    this.distance = tempDistance;
                    break;
                }
                System.out.print("Khoảng cách là số thực > 0, vui lòng nhập lại: ");
            } catch (InputMismatchException ex) {
                System.out.print("Khoảng cách là số thực, vui lòng nhập lại: ");
            }
        } while (true);
    }

    public void intputStopPoint() {
        System.out.print("Nhập số điểm dừng: ");
        int tempStopPoint = -1;
        do {
            try {
                tempStopPoint = new Scanner(System.in).nextInt();
                if (tempStopPoint > 0) {
                    this.stopPoint = tempStopPoint;
                    break;
                }
                System.out.print("Số điểm dừng là số nguyên > 0, vui lòng nhập lại: ");
            } catch (InputMismatchException ex) {
                System.out.print("Số điểm dừng là số nguyên > 0 , vui lòng nhập lại: ");
            }
        } while (true);
    }
}