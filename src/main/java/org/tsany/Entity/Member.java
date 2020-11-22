package org.tsany.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;


@Entity
    @Table(name = "penjualan",schema = "public")
    public class Member extends PanacheEntity {

    @Column(name = "namecustomers",length = 200,unique = true)
    @JsonProperty("namecustomers")
    public String namecustomer;
    @Column(name = "tanggal_transaksi",length = 200)
    @JsonFormat(pattern="yyyy-MM-dd")
    @JsonProperty("tanggal_transaksi")
    public LocalDate tanggal_transaksi;
    @Column(name = "total")
    @JsonProperty("total")
    public BigDecimal total;
}
