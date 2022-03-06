package dto;

import entity.Line;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LineTurn {
    private Line line;

    private int turnNumber;

    public float getDistance(){
        //1 lượt gồm lượt đi lượt về
        return line.getDistance()*turnNumber*2;
    }
}
