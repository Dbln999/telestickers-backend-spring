package ee.telestickers.backend.sticker;

import ee.telestickers.backend.exception.DuplicateResourceException;
import ee.telestickers.backend.exception.RequestValidationException;
import ee.telestickers.backend.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StickerService {
    private final StickerDAO stickerDAO;

    public StickerService(@Qualifier("jpa") StickerDAO stickerDAO) {
        this.stickerDAO = stickerDAO;
    }

    public List<Sticker> getALlStickers() {
        return stickerDAO.getAllStickers();
    }

    public void addSticker(StickerAddRequest stickerAddRequest) {
        String link = stickerAddRequest.link();
        if(stickerDAO.existsStickerWithLink(link)) {
            throw new DuplicateResourceException("sticker already in DB");
        }

        Sticker sticker = new Sticker(stickerAddRequest.link());
        stickerDAO.insertSticker(sticker);
    }

    public Sticker getSticker(Long id) {
        return stickerDAO.getSticker(id)
                .orElseThrow(() -> new ResourceNotFoundException("Sticker [%s] is not found".formatted(id)));
    }

    public void updateSticker(Long id, StickerUpdateRequest stickerUpdateRequest) {
        Sticker sticker = getSticker(id);

        boolean changes = false;

        if(stickerUpdateRequest.link() != null && !stickerUpdateRequest.link().equals(sticker.getLink())){
            sticker.setLink(stickerUpdateRequest.link());
            changes = true;
        }

        if(!changes) {
            throw new RequestValidationException("No data changes found");
        }

        stickerDAO.updateSticker(sticker);
    }

    public void deleteSticker(Long id) {
        if(!stickerDAO.existsStickerWithId(id)) {
            throw new ResourceNotFoundException("sticker with [%s] is not found".formatted(id));
        }

        stickerDAO.deleteSticker(id);
    }

    public List<Sticker> getStickerByIds(List<Long> stickerIds) {
        return stickerDAO.getStickerByIds(stickerIds);
    }

}
