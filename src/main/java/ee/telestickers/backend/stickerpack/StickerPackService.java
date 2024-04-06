package ee.telestickers.backend.stickerpack;

import ee.telestickers.backend.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StickerPackService{

    private final StickerPackDao stickerPackDao;
    public StickerPackService(@Qualifier("stickerpack_jpa") StickerPackDao stickerPackDao) {
        this.stickerPackDao = stickerPackDao;
    }

    public void assignStickersToStickerPack(OrderRecord order) {
        stickerPackDao.assignStickersToStickerPack(order);
    }

    public List<StickerPack> getStickerPacks() {
        return stickerPackDao.getStickerPacks();
    }

    public StickerPack getStickerPack(Long id) {
        return stickerPackDao.getStickerPack(id)
                .orElseThrow(() -> new ResourceNotFoundException("Stickerpack with id " + id + " not found"));
    }
}
