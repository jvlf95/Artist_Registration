package br.com.joao.artistregistration.main;

public enum Type {
    SOLO("solo"),
    DUO("duo"),
    BAND("band");

    private String description;

    Type(String description){
        this.description = description;
    }

    public static Type getString(String str){
        for(Type type: Type.values()){
            if(type.description.equalsIgnoreCase(str)){
                return type;
            }
        }
        throw new RuntimeException("Not a valid type!");
    }
}
