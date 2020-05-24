<template>
  <v-navigation-drawer v-model="isOpen" fixed right clipped app>
    <v-list dense>
      <v-list-item>
        <v-list-item-icon>
          <v-icon>mdi-view-dashboard</v-icon>
        </v-list-item-icon>

        <v-list-item-content>
          <v-list-item-title>test</v-list-item-title>
        </v-list-item-content>
      </v-list-item>
    </v-list>
  </v-navigation-drawer>
</template>

<script>
export default {
  data: () => ({
    isOpen: true
  }),
  methods: {
    toggleNav: function() {
      this.isOpen = !this.isOpen;
    }
  }
};
</script>