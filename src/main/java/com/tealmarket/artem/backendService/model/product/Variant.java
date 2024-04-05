package com.tealmarket.artem.backendService.model.product;

import com.tealmarket.artem.backendService.model.order.OrderItem;
import com.tealmarket.artem.backendService.model.product.details.ProductVariantImage;
import com.tealmarket.artem.backendService.model.product.details.StorageSpace;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.awt.Color;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "variant")
public class Variant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "variant_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "color_id", nullable = false)
    private Color color;

    @ManyToOne
    @JoinColumn(name = "storage_id", nullable = false)
    private StorageSpace storageSpace;

    @Column(nullable = false)
    private BigDecimal price;

    @OneToMany(mappedBy = "variant")
    private Set<OrderItem> orderItems;

    @OneToMany(mappedBy = "variant")
    private Set<ProductVariantImage> productVariantImages;
}
