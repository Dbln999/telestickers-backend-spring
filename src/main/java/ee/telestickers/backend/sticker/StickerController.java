package ee.telestickers.backend.sticker;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/stickers")
public class StickerController {
    private final StickerService stickerService;

    public StickerController(StickerService stickerService) {
        this.stickerService = stickerService;
    }

    @GetMapping
    public List<Sticker> getStickers() {
        return stickerService.getALlStickers();
    }

    @PostMapping("/ids")
    public List<Sticker> getStickerByIds(@RequestBody List<Long> stickersIds) {
        return stickerService.getStickerByIds(stickersIds);
    }

    @PostMapping("/link")
    public ResponseEntity<Sticker> getStickerByLink(@RequestBody StickerFindByLink stickerFindByLink) {
        return stickerService.getStickerByLink(stickerFindByLink.link());
    }

    @GetMapping("/{id}")
    public Sticker getSticker(@PathVariable Long id) {
        return stickerService.getSticker(id);
    }

    @PostMapping()
    public ResponseEntity<Sticker> createSticker(@RequestBody StickerAddRequest sticker) {
        return stickerService.addSticker(sticker);
    }

    @DeleteMapping("/{id}")
    public void deleteSticker(@PathVariable Long id) {
        stickerService.deleteSticker(id);
    }

    @PutMapping("/{id}")
    public void updateSticker(@PathVariable Long id, @RequestBody StickerUpdateRequest sticker) {
        stickerService.updateSticker(id, sticker);
    }
}
