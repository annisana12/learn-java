package repository; // CRUD data

import entity.TodoList;

public class TodoListRepositoryImpl implements TodoListRepository {

    private TodoList[] data = new TodoList[10]; // Data array di kelola di repository ini bukan di service

    @Override
    public TodoList[] getAll() {
        return data;
    }

    public boolean isFull() {
        // Cek apakah data penuh
        var isFull = true;

        for (var i = 0; i < data.length; i++) {
            if (data[i] == null) {
                isFull = false;
            }
        }

        return isFull;
    }

    public void resizeIfFull() {
        // Jika penuh, maka resize ukuran array 2x lipat
        if (isFull()) {
            var temp = data;
            data = new TodoList[data.length * 2];

            for (var i = 0; i < temp.length; i++) {
                data[i] = temp[i];
            }
        }
    }

    @Override
    public void add(TodoList todo) {
        resizeIfFull();

        // Tambahkan ke posisi yang data arraynya null
        for (var i = 0; i < data.length; i++) {
            if (data[i] == null) {
                data[i] = todo;
                break;
            }
        }
    }

    @Override
    public boolean remove(Integer number) {
        if ((number - 1) >= data.length) {
            return false;
        } else if (data[number - 1] == null) {
            return false;
        } else {
            for (var i = (number - 1); i < data.length; i++) {
                if (i == data.length - 1) {
                    data[i] = null;
                } else {
                    data[i] = data[i + 1];
                }
            }

            return true;
        }
    }
}
