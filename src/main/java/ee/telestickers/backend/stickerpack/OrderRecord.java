package ee.telestickers.backend.stickerpack;

import java.util.List;

public record OrderRecord(Integer tgId, List<Long> stickerIds) {
}
