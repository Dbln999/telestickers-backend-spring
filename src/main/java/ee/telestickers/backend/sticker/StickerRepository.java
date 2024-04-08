package ee.telestickers.backend.sticker;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StickerRepository extends JpaRepository<Sticker, Long> {
    boolean existsStickerById(Long id);
    boolean existsStickerByLink(String link);
    Sticker findStickerByLink(String link);
}

