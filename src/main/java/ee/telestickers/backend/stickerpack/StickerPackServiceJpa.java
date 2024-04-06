package ee.telestickers.backend.stickerpack;


import ee.telestickers.backend.customer.Customer;
import ee.telestickers.backend.customer.CustomerRepository;
import ee.telestickers.backend.sticker.Sticker;
import ee.telestickers.backend.sticker.StickerRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("stickerpack_jpa")
public class StickerPackServiceJpa implements StickerPackDao{

    private final StickerPackRepository stickerPackRepository;
    private final StickerRepository stickerRepository;
    private final CustomerRepository customerRepository;
    public StickerPackServiceJpa(StickerPackRepository stickerPackRepository, StickerRepository stickerRepository, CustomerRepository customerRepository) {
        this.stickerPackRepository = stickerPackRepository;
        this.stickerRepository = stickerRepository;
        this.customerRepository = customerRepository;
    }



    @Override
    public void assignStickersToStickerPack(OrderRecord order) {
        List<Sticker> stickers = stickerRepository.findAllById(order.stickerIds());
        Customer customer = customerRepository.findCustomerByTgId(order.tgId());
        StickerPack stickerPack = new StickerPack();
        stickerPack.setStickers(stickers);
        stickerPack.setCustomer(customer);
        stickerPackRepository.save(stickerPack);
    }

    @Override
    public List<StickerPack> getStickerPacks() {
        return stickerPackRepository.findAll();
    }

    @Override
    public Optional<StickerPack> getStickerPack(Long id) {
        return stickerPackRepository.findById(id);
    }
}
