package com.hg.danmoxiang_rrmvp.mvp.model.entity;

import android.os.Parcel;
import android.os.Parcelable;

public class Materiel implements Parcelable {
    private String ProductId;
    private String ProductCode;
    private String ProductCName;
    private String ProductEName;
    private String ProductTypeId;
    private String ProductStandard;
    private String ProductPrice;
    private String UnitID;
    private String BatchFlag;
    private String SerialFlag;
    private String DefaultCustomer;
    private String DefaultSupplier;
    private String DefaultWareHouse;
    private String DefaultWareHouseLocation;
    private String State;
    private String Remark;
    private String ImgUrl;
    private String Creator;
    private String Creator_ID;
    private String CreateTime;
    private String Editor;
    private String Editor_ID;
    private String EditTime;
    private String Deleted;
    private String IsMaterial;
    private String IsSemiFinishedProduct;
    private String IsFinishedProduct;
    private String IsOutSourcing;
    private String SafeStock;
    private String MUnitId;
    private String DUnitId;
    private String ManufactureDate;

    public String getProductId() {
        return ProductId;
    }

    public void setProductId(String productId) {
        ProductId = productId;
    }

    public String getProductCode() {
        return ProductCode;
    }

    public void setProductCode(String productCode) {
        ProductCode = productCode;
    }

    public String getProductCName() {
        return ProductCName;
    }

    public void setProductCName(String productCName) {
        ProductCName = productCName;
    }

    public String getProductEName() {
        return ProductEName;
    }

    public void setProductEName(String productEName) {
        ProductEName = productEName;
    }

    public String getProductTypeId() {
        return ProductTypeId;
    }

    public void setProductTypeId(String productTypeId) {
        ProductTypeId = productTypeId;
    }

    public String getProductStandard() {
        return ProductStandard;
    }

    public void setProductStandard(String productStandard) {
        ProductStandard = productStandard;
    }

    public String getProductPrice() {
        return ProductPrice;
    }

    public void setProductPrice(String productPrice) {
        ProductPrice = productPrice;
    }

    public String getUnitID() {
        return UnitID;
    }

    public void setUnitID(String unitID) {
        UnitID = unitID;
    }

    public String getBatchFlag() {
        return BatchFlag;
    }

    public void setBatchFlag(String batchFlag) {
        BatchFlag = batchFlag;
    }

    public String getSerialFlag() {
        return SerialFlag;
    }

    public void setSerialFlag(String serialFlag) {
        SerialFlag = serialFlag;
    }

    public String getDefaultCustomer() {
        return DefaultCustomer;
    }

    public void setDefaultCustomer(String defaultCustomer) {
        DefaultCustomer = defaultCustomer;
    }

    public String getDefaultSupplier() {
        return DefaultSupplier;
    }

    public void setDefaultSupplier(String defaultSupplier) {
        DefaultSupplier = defaultSupplier;
    }

    public String getDefaultWareHouse() {
        return DefaultWareHouse;
    }

    public void setDefaultWareHouse(String defaultWareHouse) {
        DefaultWareHouse = defaultWareHouse;
    }

    public String getDefaultWareHouseLocation() {
        return DefaultWareHouseLocation;
    }

    public void setDefaultWareHouseLocation(String defaultWareHouseLocation) {
        DefaultWareHouseLocation = defaultWareHouseLocation;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getRemark() {
        return Remark;
    }

    public void setRemark(String remark) {
        Remark = remark;
    }

    public String getImgUrl() {
        return ImgUrl;
    }

    public void setImgUrl(String imgUrl) {
        ImgUrl = imgUrl;
    }

    public String getCreator() {
        return Creator;
    }

    public void setCreator(String creator) {
        Creator = creator;
    }

    public String getCreator_ID() {
        return Creator_ID;
    }

    public void setCreator_ID(String creator_ID) {
        Creator_ID = creator_ID;
    }

    public String getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(String createTime) {
        CreateTime = createTime;
    }

    public String getEditor() {
        return Editor;
    }

    public void setEditor(String editor) {
        Editor = editor;
    }

    public String getEditor_ID() {
        return Editor_ID;
    }

    public void setEditor_ID(String editor_ID) {
        Editor_ID = editor_ID;
    }

    public String getEditTime() {
        return EditTime;
    }

    public void setEditTime(String editTime) {
        EditTime = editTime;
    }

    public String getDeleted() {
        return Deleted;
    }

    public void setDeleted(String deleted) {
        Deleted = deleted;
    }

    public String getIsMaterial() {
        return IsMaterial;
    }

    public void setIsMaterial(String isMaterial) {
        IsMaterial = isMaterial;
    }

    public String getIsSemiFinishedProduct() {
        return IsSemiFinishedProduct;
    }

    public void setIsSemiFinishedProduct(String isSemiFinishedProduct) {
        IsSemiFinishedProduct = isSemiFinishedProduct;
    }

    public String getIsFinishedProduct() {
        return IsFinishedProduct;
    }

    public void setIsFinishedProduct(String isFinishedProduct) {
        IsFinishedProduct = isFinishedProduct;
    }

    public String getIsOutSourcing() {
        return IsOutSourcing;
    }

    public void setIsOutSourcing(String isOutSourcing) {
        IsOutSourcing = isOutSourcing;
    }

    public String getSafeStock() {
        return SafeStock;
    }

    public void setSafeStock(String safeStock) {
        SafeStock = safeStock;
    }

    public String getMUnitId() {
        return MUnitId;
    }

    public void setMUnitId(String MUnitId) {
        this.MUnitId = MUnitId;
    }

    public String getDUnitId() {
        return DUnitId;
    }

    public void setDUnitId(String DUnitId) {
        this.DUnitId = DUnitId;
    }

    public String getManufactureDate() {
        return ManufactureDate;
    }

    public void setManufactureDate(String manufactureDate) {
        ManufactureDate = manufactureDate;
    }

    public String getCostPrice() {
        return CostPrice;
    }

    public void setCostPrice(String costPrice) {
        CostPrice = costPrice;
    }

    public String getMarketingPrice() {
        return MarketingPrice;
    }

    public void setMarketingPrice(String marketingPrice) {
        MarketingPrice = marketingPrice;
    }

    private String CostPrice;
    private String MarketingPrice;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.ProductId);
        dest.writeString(this.ProductCode);
        dest.writeString(this.ProductCName);
        dest.writeString(this.ProductEName);
        dest.writeString(this.ProductTypeId);
        dest.writeString(this.ProductStandard);
        dest.writeString(this.ProductPrice);
        dest.writeString(this.UnitID);
        dest.writeString(this.BatchFlag);
        dest.writeString(this.SerialFlag);
        dest.writeString(this.DefaultCustomer);
        dest.writeString(this.DefaultSupplier);
        dest.writeString(this.DefaultWareHouse);
        dest.writeString(this.DefaultWareHouseLocation);
        dest.writeString(this.State);
        dest.writeString(this.Remark);
        dest.writeString(this.ImgUrl);
        dest.writeString(this.Creator);
        dest.writeString(this.Creator_ID);
        dest.writeString(this.CreateTime);
        dest.writeString(this.Editor);
        dest.writeString(this.Editor_ID);
        dest.writeString(this.EditTime);
        dest.writeString(this.Deleted);
        dest.writeString(this.IsMaterial);
        dest.writeString(this.IsSemiFinishedProduct);
        dest.writeString(this.IsFinishedProduct);
        dest.writeString(this.IsOutSourcing);
        dest.writeString(this.SafeStock);
        dest.writeString(this.MUnitId);
        dest.writeString(this.DUnitId);
        dest.writeString(this.ManufactureDate);
        dest.writeString(this.CostPrice);
        dest.writeString(this.MarketingPrice);
    }

    public Materiel() {
    }

    protected Materiel(Parcel in) {
        this.ProductId = in.readString();
        this.ProductCode = in.readString();
        this.ProductCName = in.readString();
        this.ProductEName = in.readString();
        this.ProductTypeId = in.readString();
        this.ProductStandard = in.readString();
        this.ProductPrice = in.readString();
        this.UnitID = in.readString();
        this.BatchFlag = in.readString();
        this.SerialFlag = in.readString();
        this.DefaultCustomer = in.readString();
        this.DefaultSupplier = in.readString();
        this.DefaultWareHouse = in.readString();
        this.DefaultWareHouseLocation = in.readString();
        this.State = in.readString();
        this.Remark = in.readString();
        this.ImgUrl = in.readString();
        this.Creator = in.readString();
        this.Creator_ID = in.readString();
        this.CreateTime = in.readString();
        this.Editor = in.readString();
        this.Editor_ID = in.readString();
        this.EditTime = in.readString();
        this.Deleted = in.readString();
        this.IsMaterial = in.readString();
        this.IsSemiFinishedProduct = in.readString();
        this.IsFinishedProduct = in.readString();
        this.IsOutSourcing = in.readString();
        this.SafeStock = in.readString();
        this.MUnitId = in.readString();
        this.DUnitId = in.readString();
        this.ManufactureDate = in.readString();
        this.CostPrice = in.readString();
        this.MarketingPrice = in.readString();
    }

    public static final Parcelable.Creator<Materiel> CREATOR = new Creator<Materiel>() {
        @Override
        public Materiel createFromParcel(Parcel source) {
            return new Materiel(source);
        }

        @Override
        public Materiel[] newArray(int size) {
            return new Materiel[size];
        }
    };
}
