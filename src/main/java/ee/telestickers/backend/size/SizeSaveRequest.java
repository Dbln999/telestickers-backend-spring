package ee.telestickers.backend.size;

import java.util.List;

public record SizeSaveRequest(List<Long> stickerId, Long orderId, StickerSize size) {
}
