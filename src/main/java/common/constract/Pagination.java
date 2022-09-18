package common.constract;

import lombok.Data;

@Data
public class Pagination {
    private Integer total;

    private Integer per;

    private Integer current;

    private Integer next;
}
