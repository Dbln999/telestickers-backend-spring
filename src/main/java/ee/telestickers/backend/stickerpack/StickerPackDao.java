package ee.telestickers.backend.stickerpack;

import java.util.List;
import java.util.Optional;

public interface StickerPackDao {
    void assignStickersToStickerPack(OrderRecord order);
    List<StickerPack> getStickerPacks();
    Optional<StickerPack> getStickerPack(Long id);
}
