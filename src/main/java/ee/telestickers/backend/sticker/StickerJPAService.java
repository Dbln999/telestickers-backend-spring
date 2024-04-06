package ee.telestickers.backend.sticker;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("jpa")
public class StickerJPAService implements StickerDAO{

    private final StickerRepository stickerRepository;

    public StickerJPAService(StickerRepository stickerRepository) {
        this.stickerRepository = stickerRepository;
    }

    @Override
    public List<Sticker> getAllStickers() {
        return stickerRepository.findAll();
    }

    @Override
    public List<Sticker> getStickerByIds(List<Long> stickerIds) {
        return stickerRepository.findAllById(stickerIds);
    }

    @Override
    public Optional<Sticker> getSticker(Long id) {
        return stickerRepository.findById(id);
    }

    @Override
    public void insertSticker(Sticker sticker) {
        stickerRepository.save(sticker);
    }

    @Override
    public void updateSticker(Sticker sticker) {
        stickerRepository.save(sticker);
    }

    @Override
    public void deleteSticker(Long id) {
        stickerRepository.deleteById(id);
    }

    @Override
    public boolean existsStickerWithId(Long id) {
        return stickerRepository.existsById(id);
    }

    @Override
    public boolean existsStickerWithLink(String link) {
        return stickerRepository.existsStickerByLink(link);
    }
}
