package data;

import java.io.Serializable;
import java.time.LocalDate;

public record User(String name, String user_id, LocalDate entry_time, Boolean valid) implements Serializable{};
