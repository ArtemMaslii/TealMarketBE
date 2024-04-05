package com.tealmarket.artem.backendService.model.product.details;

import com.tealmarket.artem.backendService.model.product.Variant;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "product_variant_image")
public class ProductVariantImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "variant_id", referencedColumnName = "variant_id", nullable = false)
    private Variant variant;

    @Column(name = "image_url", nullable = false, unique = true)
    private String imageUrl;
}
