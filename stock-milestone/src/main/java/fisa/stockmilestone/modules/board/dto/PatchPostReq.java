package fisa.stockmilestone.modules.board.dto;

import lombok.Data;

@Data
public class PatchPostReq {
    private final Long id;
    private final String content;
}
