package ee.telestickers.backend.sticker;

import java.util.List;
import java.util.Optional;

public interface StickerDAO {

    List<Sticker> getAllStickers();
    List<Sticker> getStickerByIds(List<Long> stickerIds);
    Optional<Sticker> getSticker(Long id);
    void insertSticker(Sticker sticker);
    void updateSticker(Sticker sticker);
    void deleteSticker(Long id);
    boolean existsStickerWithId(Long id);
    boolean existsStickerWithLink(String link);

}
