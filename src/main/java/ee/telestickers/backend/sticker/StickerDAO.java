package ee.telestickers.backend.sticker;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface StickerDAO {

    List<Sticker> getAllStickers();
    List<Sticker> getStickerByIds(List<Long> stickerIds);
    Optional<Sticker> getSticker(Long id);
    ResponseEntity<Sticker> insertSticker(Sticker sticker);
    ResponseEntity<Sticker> getStickerByLink(String link);
    void updateSticker(Sticker sticker);
    void deleteSticker(Long id);
    boolean existsStickerWithId(Long id);
    boolean existsStickerWithLink(String link);

}
