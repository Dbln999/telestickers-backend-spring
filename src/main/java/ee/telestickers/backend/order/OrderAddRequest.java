package ee.telestickers.backend.order;

public record OrderAddRequest(Integer tgId, Long stickerPackId, Long printfulId) {
}
