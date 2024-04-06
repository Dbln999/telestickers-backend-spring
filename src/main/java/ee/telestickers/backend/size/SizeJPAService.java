package ee.telestickers.backend.size;

import ee.telestickers.backend.order.Order;
import ee.telestickers.backend.order.OrderRepository;
import ee.telestickers.backend.sticker.Sticker;
import ee.telestickers.backend.sticker.StickerRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("sizejpa")
public class SizeJPAService implements SizeDao{

    private final SizeRepository sizeRepository;
    private final StickerRepository stickerRepository;
    private final OrderRepository orderRepository;

    public SizeJPAService(SizeRepository sizeRepository, StickerRepository stickerRepository, OrderRepository orderRepository) {
        this.sizeRepository = sizeRepository;
        this.stickerRepository = stickerRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Size> getAllSizes() {
        return sizeRepository.findAll();
    }

    @Override
    public Size getSizeByStickerId(Long stickerId) {
        return sizeRepository.findSizeByStickersId(stickerId);
    }

    @Override
    public void saveSizeToSticker(SizeSaveRequest save) {
        Optional<Order> order = orderRepository.findById(save.orderId());
        List<Sticker> stickers = stickerRepository.findAllById(save.stickerId());
        Size size = new Size(save.size(), order.orElse(null), stickers);
        sizeRepository.save(size);

    }


}
