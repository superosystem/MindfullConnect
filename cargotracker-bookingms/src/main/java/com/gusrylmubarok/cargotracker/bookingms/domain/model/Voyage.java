package com.gusrylmubarok.cargotracker.bookingms.domain.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
/*
** Class representing the cargo Voyage
 */
@Embeddable
public class Voyage {
    @Column(name = "voyage_number", insertable = false, updatable = false)
    private String voyageNumber;

    public Voyage() {
    }

    public Voyage(String voyageNumber) {
        this.voyageNumber = voyageNumber;
    }

    public String getVoyageNumber() {
        return voyageNumber;
    }

    public void setVoyageNumber(String voyageNumber) {
        this.voyageNumber = voyageNumber;
    }
}
