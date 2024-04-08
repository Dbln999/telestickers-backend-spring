package ee.telestickers.backend.stickerpack;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface StickerPackDao {
    ResponseEntity<StickerPack> assignStickersToStickerPack(OrderRecord order);
    List<StickerPack> getStickerPacks();
    Optional<StickerPack> getStickerPack(Long id);
}
