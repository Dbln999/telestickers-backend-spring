package ee.telestickers.backend.size;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SizeService {
    private final SizeDao sizeDao;
    public SizeService(@Qualifier("sizejpa") SizeDao sizeDao) {
        this.sizeDao = sizeDao;
    }

    public List<Size> getAllSized() {
        return sizeDao.getAllSizes();
    }

    public Size getSizeByStickerId(Long id) {
        return sizeDao.getSizeByStickerId(id);
    }

    public ResponseEntity<Size> saveSize(SizeSaveRequest size) {
        return sizeDao.saveSizeToSticker(size);
    }
}
