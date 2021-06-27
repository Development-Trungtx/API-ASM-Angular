package com.trungtx.poly.ServiceImpl;

import com.trungtx.poly.Dto.CartProductDto;
import com.trungtx.poly.Dto.ProductDto;
import com.trungtx.poly.Entity.Cart_Product;
import com.trungtx.poly.Entity.Order;
import com.trungtx.poly.Entity.Product;
import com.trungtx.poly.Repository.CartProRepository;
import com.trungtx.poly.Repository.OrderRepository;
import com.trungtx.poly.Repository.ProductRepository;
import com.trungtx.poly.Service.CartProService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartProServiceImpl implements CartProService {

    @Autowired
    private CartProRepository cartProRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public List<CartProductDto> fildAllCartProduct() {
        try {
            List<CartProductDto> cartProductDto = new ArrayList<>();
            List<Cart_Product> cart_productList = cartProRepository.findAll();
            for (Cart_Product cp : cart_productList) {
                cartProductDto.add(new CartProductDto(cp.getCardProductId(), cp.getProduct().getImage(), cp.getProduct().getPrice(), cp.getAmount(), cp.getOrder().getNameOrder(),
                        cp.getProduct().getName()));
            }
            Type listType = new TypeToken<List<CartProductDto>>() {
            }.getType();
            List<CartProductDto> pr = modelMapper.map(cartProductDto, listType);
            return pr;
        } catch (Exception exception) {
            return null;
        }
    }

    @Override
    public List<CartProductDto> insertCartProduct(List<CartProductDto> cartProductDto, String nameOrder) {
        try {
            Order order = orderRepository.findIdByNameOder(nameOrder);
            for (CartProductDto pr : cartProductDto) {
//                Product product = productRepository.findIdByNamePro(pr.getProName());
                Product product = productRepository.findById(pr.getProductID()).get();
                product.setTotal(product.getTotal() - pr.getAmount());
                Cart_Product cart_product = modelMapper.map(new Cart_Product(null, pr.getAmount(), order, product), Cart_Product.class);
                cartProRepository.save(cart_product);
            }
            return cartProductDto;
        } catch (Exception exception) {
            return null;
        }
    }

    @Override
    public CartProductDto updateCartProduct(CartProductDto cartProductDto) {
        try {
            Product product = productRepository.findIdByNamePro(cartProductDto.getProName());
            Order order = orderRepository.findIdByNameOder(cartProductDto.getOrderNumber());
            Cart_Product cart_product = modelMapper.map(new Cart_Product(cartProductDto.getCardProductId(), cartProductDto.getAmount(), order, product), Cart_Product.class);
            cartProRepository.save(cart_product);
            return cartProductDto;
        } catch (Exception exception) {
            return null;
        }
    }


    @Override
    public CartProductDto findCartProById(int id) {
        try {
            Optional<Cart_Product> cart_product = cartProRepository.findById(id);
            CartProductDto cartProductDto = modelMapper.map(new CartProductDto(cart_product.get().getCardProductId(), cart_product.get().getProduct().getImage(),
                    cart_product.get().getProduct().getPrice(), cart_product.get().getAmount(), cart_product.get().getOrder().getNameOrder(),
                    cart_product.get().getProduct().getName()), CartProductDto.class);
            return cartProductDto;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<CartProductDto> findCartByOrderName(int nameCart) {
        try {
            List<CartProductDto> cartProductDto = new ArrayList<>();
            List<Cart_Product> cart_productList = cartProRepository.findCartByOder(nameCart);
            for (Cart_Product cp : cart_productList) {
                cartProductDto.add(new CartProductDto(cp.getCardProductId(), cp.getProduct().getImage(), cp.getProduct().getPrice(), cp.getAmount(), cp.getOrder().getNameOrder(),
                        cp.getProduct().getName()));
            }
            Type listType = new TypeToken<List<CartProductDto>>() {
            }.getType();
            List<CartProductDto> pr = modelMapper.map(cartProductDto, listType);
            return pr;
        } catch (Exception exception) {
            return null;
        }
    }

    @Override
    public CartProductDto deleteCartProduct(int id) {
        try {
            CartProductDto cartProductDto = findCartProById(id);
            cartProRepository.deleteById(id);
            return cartProductDto;
        } catch (Exception e) {
            return null;
        }
    }
}
