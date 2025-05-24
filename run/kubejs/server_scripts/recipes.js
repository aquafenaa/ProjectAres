// priority: 1
// requires: create
// requires: project_ares
// requires: destroy

// Visit the wiki for more info - https://kubejs.com/

ServerEvents.recipes(recipeRegister => {
  recipeRegister.remove({ id: 'create_new_age:shaped/generator_coil' });

  // recipeRegister.recipes.create.

  recipeRegister.recipes.create.mechanical_crafting('create_new_age:generator_coil', [
    ' CCC ',
    'CPHPC',
    'CHSHC',
    'CPHPC',
    ' CCC '
  ], {
    C: 'project_ares:finished_stator',
    P: 'destroy:stainless_steel_sheet',
    H: 'create:shaft',
    S: 'project_ares:finished_rotor'
  })
});
