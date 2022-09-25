package common.model;

import common.constract.Platform;
import lombok.Data;

@Data
public class ProofInfo {
    private Platform platform;
    private String identity;
    private String createAt;
    private String lastCheckedAt;
    private Boolean isValid;
    private String isValidReason;
}
