<template>
  <v-navigation-drawer v-model="isOpen" fixed right clipped app>
    <v-list dense>
      <v-list-item 
          v-for="item in items"
          :key="item.title"
          @click="changeRoute(item.path)">

        <v-list-item-icon>
          <v-icon>{{ item.icon }}</v-icon>
        </v-list-item-icon>

        <v-list-item-content>
          <v-list-item-title>{{ item.title }}</v-list-item-title>
        </v-list-item-content>
      </v-list-item>
    </v-list>
  </v-navigation-drawer>
</template>

<script>

import router from '../router'

export default {
  data: () => ({
    isOpen: true,
    items: [
      { title: "Users", icon: "mdi-home-city", path: "users" },
    ]
  }),
  methods: {
    toggleNav: function() {
      this.isOpen = !this.isOpen;
    },
    changeRoute: function(path) {
      router.push( '/admin/' + path )
    }
  }
};
</script>