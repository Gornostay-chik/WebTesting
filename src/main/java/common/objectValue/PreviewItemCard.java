package common.objectValue;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PreviewItemCard {
    public String itemName;
    public String itemDescription;
    public double itemPrice;
}
