package case_study_2.furama_resort.untils.enum_furama;

public enum EnumFurama {
    RECEPTIONIST("Lễ tân"),
    SERVE("Phục vụ"),
    EXPERT("Chuyên viên"),
    MONITOR("Giám sát"),
    MANAGE("Quản lý"),
    MANAGER("Giám đốc"),
    INTERMEDIATE("Trung cấp"),
    COLLEGE("Cao đẳng"),
    UNIVERSITY("Đại học"),
    AFTER_UNIVERSITY("Sau đại học"),
    MALE("Nam"),
    FEMALE("Nữ"),
    SUBURBAN("Ngoại ô"),
    COAST("Bờ biển"),
    DOWNTOWN("Trung tâm thành phố"),
    MIDDLE_DOWNTOWN("Giữa thành phố"),
    ISLAND("Hòn đảo"),
    DIAMOND("Diamond"),
    PLATINUM("Platinum"),
    GOLD("Gold"),
    SILVER("Silver"),
    MEMBER("Member"),
    FREE_MASSAGE_SERVICE("Dịch vụ Massage miễn phí"),
    PERSONAL_RELAXATION_SERVICE("Dịch vụ câu cá thư giãn"),
    GOLF_PARTICIPATION_SERVICE("Dịch vụ tham gia đánh Gôn"),
    THREE_STARS("Ba sao"),
    FOUR_STARS("Bốn sao"),
    FIVE_STARS("Năm sao"),
    TYPE_YEAR("Năm"),
    TYPE_MONTH("Tháng"),
    TYPE_DATE("Ngày"),
    TYPE_HOUR("Giờ"),
    TYPE_VILLA("Villa"),
    TYPE_HOUSE("House"),
    TYPE_ROOM("Room");

    private String value;

    EnumFurama(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
