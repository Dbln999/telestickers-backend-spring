package ee.telestickers.backend.size;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SizeDao {
    List<Size> getAllSizes();
    Size getSizeByStickerId(Long stickerId);
    ResponseEntity<Size> saveSizeToSticker(SizeSaveRequest size);
}
