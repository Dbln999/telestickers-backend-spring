package ee.telestickers.backend.stickerpack;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/stickerpack")
public class StickerPackController {

    private final StickerPackService stickerPackService;
    public StickerPackController(StickerPackService stickerPackService) {
        this.stickerPackService = stickerPackService;
    }

    @PostMapping()
    public ResponseEntity<StickerPack> assignStickersToStickerPack(@RequestBody OrderRecord order) {
        return stickerPackService.assignStickersToStickerPack(order);
    }

    @GetMapping
    public List<StickerPack> getStickerPacks() {
        return stickerPackService.getStickerPacks();
    }

    @GetMapping("/{id}")
    public StickerPack getStickerPack(@PathVariable Long id) {
        return stickerPackService.getStickerPack(id);
    }
}
