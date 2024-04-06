package ee.telestickers.backend.size;

import java.util.List;

public interface SizeDao {
    List<Size> getAllSizes();
    Size getSizeByStickerId(Long stickerId);
    void saveSizeToSticker(SizeSaveRequest size);
}
