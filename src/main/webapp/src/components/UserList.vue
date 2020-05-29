<template>
  <v-row align="start" justify="start">
    <v-col cols="12">
      <v-data-table :headers="headers" :items="data" :items-per-page="5" class="elevation-1">
        <template v-slot:top>
          <v-dialog v-model="dialog" max-width="500px">
            <template v-slot:activator="{ on }">
              <v-btn color="primary" dark class="mb-2" v-on="on">ایجاد</v-btn>
            </template>
            <v-card>
              <v-card-title>
                <span class="headline">{{ formTitle }}</span>
              </v-card-title>

              <v-card-text>
                <v-container>
                  <v-row>
                    <v-col cols="12" sm="12">
                      <v-text-field v-model="editedItem.name" label="نام کاربری"></v-text-field>
                    </v-col>
                    <v-col cols="12" sm="12">
                      <v-text-field v-model="editedItem.password" label="گذرواژه"></v-text-field>
                    </v-col>
                  </v-row>
                </v-container>
              </v-card-text>

              <v-card-actions>
                <v-spacer></v-spacer>
                <v-btn color="blue darken-1" text @click="close">بستن</v-btn>
                <v-btn color="blue darken-1" text @click="save">ذخیره</v-btn>
              </v-card-actions>
            </v-card>
          </v-dialog>
        </template>

        <template v-slot:item.actions="{item}">
          <v-icon small  @click="deleteItem(item)">mdi-delete</v-icon>
        </template>
      </v-data-table>
    </v-col>
  </v-row>
</template>

<script>
import RestUtil from "../lib/RestUtil";

export default {
  data: () => ({
    headers: [
      {
        text: "نام کاربری",
        sortable: false,
        value: "username"
      },
      {
        text: "عملیات",
        sortable: false,
        value: "actions"
      }
    ],
    data: [],
    selectedItems: [] ,
    editedItem: {
      name: null,
      password: null
    },
    dialog: false,
    formTitle: 'ایجاد کاربر'
  }),
  watch: {
    selectedItems: function(newOne, oldOne) {
      console.log("new ", newOne, " old ", oldOne);
    }
  },
  mounted: function() {
    this.reloadUserList();
  },
  methods: {
    deleteItem: function(item) {
      RestUtil.delete("/rest/user/" + item.id).then(resp => {
        console.log("resp ", resp)
        this.reloadUserList();
      });
    },
    save: function() {

    },
    close: function() {
      this.dialog = false
    },
    reloadUserList: function() {
      RestUtil.get("/rest/user/search").then(resp => {
        this.data = resp.data;
      });
    }
  }
};
</script>

<style>
</style>