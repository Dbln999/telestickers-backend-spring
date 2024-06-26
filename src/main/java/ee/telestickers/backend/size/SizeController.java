package ee.telestickers.backend.size;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/size")
public class SizeController {
    private final SizeService sizeService;

    public SizeController(SizeService sizeService) {
        this.sizeService = sizeService;
    }

    @GetMapping
    public List<Size> getSize() {
        return sizeService.getAllSized();
    }

    @GetMapping("/{id}")
    public Size getSizeByStickerId(@PathVariable("id") Long id) {
        return sizeService.getSizeByStickerId(id);
    }

    @PostMapping
    public ResponseEntity<Size> createSize(@RequestBody SizeSaveRequest size) {
        return sizeService.saveSize(size);
    }
}
