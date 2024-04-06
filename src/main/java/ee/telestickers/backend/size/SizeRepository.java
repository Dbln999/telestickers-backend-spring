package ee.telestickers.backend.size;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SizeRepository extends JpaRepository<Size, Long> {
    Size findSizeByStickersId(Long stickersId);
}
