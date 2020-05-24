<template>
  <v-row
      align="start"
      justify="start">
    <v-col cols="12">
      <v-data-table :headers="headers" :items="desserts" :items-per-page="5" class="elevation-1"></v-data-table>
    </v-col>
  </v-row>
</template>

<script>
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
        sortable: false
      }
    ],
    desserts: [
      {
        username: "ali"
      },
      {
        username: "ali 2"
      }
    ]
  }),

  methods: {}
};
</script>

<style>
</style>