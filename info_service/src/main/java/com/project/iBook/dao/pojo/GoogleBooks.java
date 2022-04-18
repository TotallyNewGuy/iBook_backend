package com.project.iBook.dao.pojo;

public class GoogleBooks {
    private Items[] items;

    private Integer totalItems;

    private String kind;

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Items[] getItems (){
        return items;
    }

    public void setItems (Items[] items){
        this.items = items;
    }

    public Integer getTotalItems (){
        return totalItems;
    }

    public void setTotalItems (Integer totalItems) {
        this.totalItems = totalItems;
    }

    public String getKind () {
        return kind;
    }

    public void setKind (String kind) {
        this.kind = kind;
    }

    public class Items {
        private SaleInfo saleInfo;
        private SearchInfo searchInfo;
        private String kind;
        private VolumeInfo volumeInfo;
        private String etag;
        private String id;
        private AccessInfo accessInfo;
        private String selfLink;

        public SaleInfo getSaleInfo () {
            return saleInfo;
        }

        public void setSaleInfo (SaleInfo saleInfo) {
            this.saleInfo = saleInfo;
        }

        public String getId () {
            return id;
        }

        public void setId (String id) {
            this.id = id;
        }

        public SearchInfo getSearchInfo () {
            return searchInfo;
        }

        public void setSearchInfo (SearchInfo searchInfo) {
            this.searchInfo = searchInfo;
        }

        public String getEtag () {
            return etag;
        }

        public void setEtag (String etag) {
            this.etag = etag;
        }

        public VolumeInfo getVolumeInfo () {
            return volumeInfo;
        }

        public void setVolumeInfo (VolumeInfo volumeInfo) {
            this.volumeInfo = volumeInfo;
        }

        public String getSelfLink () {
            return selfLink;
        }

        public void setSelfLink (String selfLink) {
            this.selfLink = selfLink;
        }

        public AccessInfo getAccessInfo () {
            return accessInfo;
        }

        public void setAccessInfo (AccessInfo accessInfo) {
            this.accessInfo = accessInfo;
        }

        public String getKind () {
            return kind;
        }

        public void setKind (String kind) {
            this.kind = kind;
        }

        public class SaleInfo {
            private Offers[] offers;
            private String country;
            private Boolean isEbook;
            private String saleability;
            private String buyLink;
            private RetailPrice retailPrice;
            private ListPrice listPrice;

            public RetailPrice getRetailPrice () {
                return retailPrice;
            }

            public void setRetailPrice (RetailPrice retailPrice) {
                this.retailPrice = retailPrice;
            }

            public String getSaleability () {
                return saleability;
            }

            public void setSaleability (String saleability) {
                this.saleability = saleability;
            }

            public ListPrice getListPrice () {
                return listPrice;
            }

            public void setListPrice (ListPrice listPrice) {
                this.listPrice = listPrice;
            }

            public Offers[] getOffers () {
                return offers;
            }

            public void setOffers (Offers[] offers) {
                this.offers = offers;
            }

            public String getBuyLink () {
                return buyLink;
            }

            public void setBuyLink (String buyLink) {
                this.buyLink = buyLink;
            }

            public Boolean getIsEbook () {
                return isEbook;
            }

            public void setIsEbook (Boolean isEbook) {
                this.isEbook = isEbook;
            }

            public String getCountry () {
                return country;
            }

            public void setCountry (String country) {
                this.country = country;
            }

            public class Offers {
                private RetailPrice retailPrice;

                private ListPrice listPrice;

                private String finskyOfferType;

                public RetailPrice getRetailPrice () {
                    return retailPrice;
                }

                public void setRetailPrice (RetailPrice retailPrice) {
                    this.retailPrice = retailPrice;
                }

                public ListPrice getListPrice () {
                    return listPrice;
                }

                public void setListPrice (ListPrice listPrice) {
                    this.listPrice = listPrice;
                }

                public String getFinskyOfferType () {
                    return finskyOfferType;
                }

                public void setFinskyOfferType (String finskyOfferType) {
                    this.finskyOfferType = finskyOfferType;
                }
            }

            public class RetailPrice {
                private String amount;

                private String currencyCode;

                public String getAmount () {
                    return amount;
                }

                public void setAmount (String amount) {
                    this.amount = amount;
                }

                public String getCurrencyCode () {
                    return currencyCode;
                }

                public void setCurrencyCode (String currencyCode) {
                    this.currencyCode = currencyCode;
                }
            }

            public class ListPrice {
                private Double amount;

                private String currencyCode;

                public Double getAmount () {
                    return amount;
                }

                public void setAmount (Double amount) {
                    this.amount = amount;
                }

                public String getCurrencyCode () {
                    return currencyCode;
                }

                public void setCurrencyCode (String currencyCode) {
                    this.currencyCode = currencyCode;
                }
            }
        }

        public class SearchInfo {
            private String textSnippet;

            public String getTextSnippet () {
                return textSnippet;
            }

            public void setTextSnippet (String textSnippet) {
                this.textSnippet = textSnippet;
            }
        }

        public class VolumeInfo {
            private IndustryIdentifiers[] industryIdentifiers;
            private Integer pageCount;
            private String printType;
            private Double averageRating;
            private ReadingModes readingModes;
            private String previewLink;
            private String canonicalVolumeLink;
            private String description;
            private String language;
            private String title;
            private ImageLinks imageLinks;
            private PanelizationSummary panelizationSummary;
            private String subtitle;
            private Integer ratingsCount;
            private String publisher;
            private String publishedDate;
            private Dimensions dimensions;
            private String mainCategory;
            private String[] categories;
            private String maturityRating;
            private Boolean allowAnonLogging;
            private String contentVersion;
            private String[] authors;
            private String infoLink;

            public String getMainCategory() {
                return mainCategory;
            }

            public void setMainCategory(String mainCategory) {
                this.mainCategory = mainCategory;
            }

            public PanelizationSummary getPanelizationSummary() {
                return panelizationSummary;
            }

            public void setPanelizationSummary(PanelizationSummary panelizationSummary) {
                this.panelizationSummary = panelizationSummary;
            }

            public String getSubtitle() {
                return subtitle;
            }

            public void setSubtitle(String subtitle) {
                this.subtitle = subtitle;
            }

            public Integer getPageCount () {
                return pageCount;
            }

            public void setPageCount (Integer pageCount) {
                this.pageCount = pageCount;
            }

            public Double getAverageRating () {
                return averageRating;
            }

            public void setAverageRating (Double averageRating) {
                this.averageRating = averageRating;
            }

            public ReadingModes getReadingModes () {
                return readingModes;
            }

            public void setReadingModes (ReadingModes readingModes) {
                this.readingModes = readingModes;
            }

            public String getInfoLink () {
                return infoLink;
            }

            public void setInfoLink (String infoLink) {
                this.infoLink = infoLink;
            }

            public String getPrintType () {
                return printType;
            }

            public void setPrintType (String printType) {
                this.printType = printType;
            }

            public Boolean getAllowAnonLogging () {
                return allowAnonLogging;
            }

            public void setAllowAnonLogging (Boolean allowAnonLogging) {
                this.allowAnonLogging = allowAnonLogging;
            }

            public String getPublisher () {
                return publisher;
            }

            public void setPublisher (String publisher) {
                this.publisher = publisher;
            }

            public String[] getAuthors () {
                return authors;
            }

            public void setAuthors (String[] authors) {
                this.authors = authors;
            }

            public String getCanonicalVolumeLink () {
                return canonicalVolumeLink;
            }

            public void setCanonicalVolumeLink (String canonicalVolumeLink) {
                this.canonicalVolumeLink = canonicalVolumeLink;
            }

            public String getTitle () {
                return title;
            }

            public void setTitle (String title) {
                this.title = title;
            }

            public String getPreviewLink () {
                return previewLink;
            }

            public void setPreviewLink (String previewLink) {
                this.previewLink = previewLink;
            }

            public String getDescription () {
                return description;
            }

            public void setDescription (String description) {
                this.description = description;
            }

            public Integer getRatingsCount () {
                return ratingsCount;
            }

            public void setRatingsCount (Integer ratingsCount) {
                this.ratingsCount = ratingsCount;
            }

            public ImageLinks getImageLinks () {
                return imageLinks;
            }

            public void setImageLinks (ImageLinks imageLinks) {
                this.imageLinks = imageLinks;
            }

            public String getContentVersion () {
                return contentVersion;
            }

            public void setContentVersion (String contentVersion) {
                this.contentVersion = contentVersion;
            }

            public String[] getCategories () {
                return categories;
            }

            public void setCategories (String[] categories) {
                this.categories = categories;
            }

            public String getLanguage () {
                return language;
            }

            public void setLanguage (String language) {
                this.language = language;
            }

            public String getPublishedDate () {
                return publishedDate;
            }

            public void setPublishedDate (String publishedDate) {
                this.publishedDate = publishedDate;
            }

            public IndustryIdentifiers[] getIndustryIdentifiers () {
                return industryIdentifiers;
            }

            public void setIndustryIdentifiers (IndustryIdentifiers[] industryIdentifiers) {
                this.industryIdentifiers = industryIdentifiers;
            }

            public String getMaturityRating () {
                return maturityRating;
            }

            public void setMaturityRating (String maturityRating) {
                this.maturityRating = maturityRating;
            }

            public Dimensions getDimensions() {
                return dimensions;
            }

            public void setDimensions(Dimensions dimensions) {
                this.dimensions = dimensions;
            }

            public class ImageLinks {
                private String thumbnail;
                private String smallThumbnail;
                private String small;
                private String medium;
                private String large;
                private String extraLarge;

                public String getThumbnail () {
                    return thumbnail;
                }

                public void setThumbnail (String thumbnail) {
                    this.thumbnail = thumbnail;
                }

                public String getSmallThumbnail () {
                    return smallThumbnail;
                }

                public void setSmallThumbnail (String smallThumbnail) {
                    this.smallThumbnail = smallThumbnail;
                }

                public String getSmall() {
                    return small;
                }

                public String getMedium() {
                    return medium;
                }

                public String getLarge() {
                    return large;
                }

                public String getExtraLarge() {
                    return extraLarge;
                }

                public void setSmall(String small) {
                    this.small = small;
                }

                public void setMedium(String medium) {
                    this.medium = medium;
                }

                public void setLarge(String large) {
                    this.large = large;
                }

                public void setExtraLarge(String extraLarge) {
                    this.extraLarge = extraLarge;
                }

//                @Override
//                public String toString() {
//                    return thumbnail + "\n" +
//                            smallThumbnail + "\n" +
//                            small + "\n" +
//                            medium + "\n" +
//                            large + "\n" +
//                            extraLarge;
//                }

                @Override
                public String toString() {
                    return "Some links";
                }

            }

            public class Dimensions {
                private String height;
                private String width;
                private String thickness;

                public String getHeight() {
                    return height;
                }

                public String getThickness() {
                    return thickness;
                }

                public String getWidth() {
                    return width;
                }

                public void setHeight(String height) {
                    this.height = height;
                }

                public void setThickness(String thickness) {
                    this.thickness = thickness;
                }

                public void setWidth(String width) {
                    this.width = width;
                }
            }

            public class PanelizationSummary {
                private Boolean containsImageBubbles;
                private Boolean containsEpubBubbles;

                public Boolean getContainsEpubBubbles() {
                    return containsEpubBubbles;
                }

                public void setContainsEpubBubbles(Boolean containsEpubBubbles) {
                    this.containsEpubBubbles = containsEpubBubbles;
                }

                public Boolean getContainsImageBubbles() {
                    return containsImageBubbles;
                }

                public void setContainsImageBubbles(Boolean containsImageBubbles) {
                    this.containsImageBubbles = containsImageBubbles;
                }
            }

            public class ReadingModes {
                private Boolean text;

                private Boolean image;

                public Boolean getText () {
                    return text;
                }

                public void setText (Boolean text) {
                    this.text = text;
                }

                public Boolean getImage () {
                    return image;
                }

                public void setImage (Boolean image) {
                    this.image = image;
                }
            }

            public class IndustryIdentifiers {
                private String type;

                private String identifier;

                public String getType () {
                    return type;
                }

                public void setType (String type) {
                    this.type = type;
                }

                public String getIdentifier () {
                    return identifier;
                }

                public void setIdentifier (String identifier) {
                    this.identifier = identifier;
                }
            }
        }

        public class AccessInfo {
            private String accessViewStatus;
            private String country;
            private String viewability;
            private Pdf pdf;
            private String webReaderLink;
            private Epub epub;
            private Boolean publicDomain;
            private Boolean quoteSharingAllowed;
            private Boolean embeddable;
            private String textToSpeechPermission;

            public String getWebReaderLink () {
                return webReaderLink;
            }

            public void setWebReaderLink (String webReaderLink) {
                this.webReaderLink = webReaderLink;
            }

            public String getTextToSpeechPermission () {
                return textToSpeechPermission;
            }

            public void setTextToSpeechPermission (String textToSpeechPermission) {
                this.textToSpeechPermission = textToSpeechPermission;
            }

            public Boolean getPublicDomain () {
                return publicDomain;
            }

            public void setPublicDomain (Boolean publicDomain) {
                this.publicDomain = publicDomain;
            }

            public String getViewability () {
                return viewability;
            }

            public void setViewability (String viewability) {
                this.viewability = viewability;
            }

            public String getAccessViewStatus () {
                return accessViewStatus;
            }

            public void setAccessViewStatus (String accessViewStatus) {
                this.accessViewStatus = accessViewStatus;
            }

            public Pdf getPdf () {
                return pdf;
            }

            public void setPdf (Pdf pdf) {
                this.pdf = pdf;
            }

            public Epub getEpub () {
                return epub;
            }

            public void setEpub (Epub epub) {
                this.epub = epub;
            }

            public Boolean getEmbeddable () {
                return embeddable;
            }

            public void setEmbeddable (Boolean embeddable) {
                this.embeddable = embeddable;
            }

            public Boolean getQuoteSharingAllowed () {
                return quoteSharingAllowed;
            }

            public void setQuoteSharingAllowed (Boolean quoteSharingAllowed) {
                this.quoteSharingAllowed = quoteSharingAllowed;
            }

            public String getCountry () {
                return country;
            }

            public void setCountry (String country) {
                this.country = country;
            }

            public class Pdf {
                private String acsTokenLink;

                private Boolean isAvailable;

                public String getAcsTokenLink () {
                    return acsTokenLink;
                }

                public void setAcsTokenLink (String acsTokenLink) {
                    this.acsTokenLink = acsTokenLink;
                }

                public Boolean getIsAvailable () {
                    return isAvailable;
                }

                public void setIsAvailable (Boolean isAvailable) {
                    this.isAvailable = isAvailable;
                }
            }

            public class Epub {
                private String acsTokenLink;

                private String isAvailable;

                public String getAcsTokenLink () {
                    return acsTokenLink;
                }

                public void setAcsTokenLink (String acsTokenLink) {
                    this.acsTokenLink = acsTokenLink;
                }

                public String getIsAvailable () {
                    return isAvailable;
                }

                public void setIsAvailable (String isAvailable) {
                    this.isAvailable = isAvailable;
                }
            }
        }

    }
}