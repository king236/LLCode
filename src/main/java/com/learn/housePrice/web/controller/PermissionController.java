package com.learn.housePrice.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.learn.housePrice.entity.Permission;
import com.learn.housePrice.service.PermissionService;
import com.learn.housePrice.service.RoleService;
import com.learn.housePrice.common.util.Result;
import com.learn.housePrice.common.util.ZtreeView;

@Controller
@RequestMapping(value="/admin/permission")
public class PermissionController {

	@Autowired
	private PermissionService permissionService;
	@Autowired
	private RoleService roleService;
	
	@RequestMapping(value = "/index")
	public String index() {
		return "/admin/permission/index";
	}

	@RequestMapping(value = "/leftPermissionData", method = RequestMethod.POST)
	@ResponseBody
	public List<Map<String, Object>> leftPermissionData() {
		List<Map<String, Object>> permissionAll = new ArrayList<>();
		/*List<Permission> permissionParentList = permissionDao.getPermissionParent();

		if (permissionParentList != null && permissionParentList.size() > 0) {
			for (Permission permission : permissionParentList) {
				Map<String, Object> map = new HashMap<>();
				map.put("permissionName", permission.getPermissionName());

				Map<String, Object> params = new HashMap<>();
				params.put("parentId", permission.getId());
				List<Permission> permissionChildList = permissionDao.getPermissionChild(params);
				if (permissionChildList != null && permissionChildList.size() > 0) {
					map.put("children", permissionChildList);
				}

				permissionAll.add(map);
			}
		}*/
		return permissionAll;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public Result addPermission(Permission permission) {
		try {
			// if(StringUtils.isBlank(permission.getParentId())){
			// permission.setParentId(null);
			// }
			Long maxSort = permissionService.getSortMax(permission);
			permission.setSort((Long) (maxSort + 1));
			Long id = permissionService.insert(permission);
			if (id == 1L) {
				return Result.success("权限插入成功");
			} else {
				return Result.failure("权限插入失败");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return Result.failure(e.getMessage());
		}
	}

	@RequestMapping(value = "/add/{id}", method = RequestMethod.GET)
	public String add(@PathVariable Long id, Model model) {
		if (id > 0) {
			model.addAttribute("permission", permissionService.findById(id));
		}
		return "admin/permission/form";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable Long id, Model model) {
		try {
			Permission permission = permissionService.findById(id);
			if (permission.getParentId() != 0) {
				model.addAttribute("permissionParent", permissionService.findById(permission.getParentId()));
			}
			model.addAttribute("permission", permission);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "admin/permission/edit";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	@ResponseBody
	public Result edit(Permission permission) {
		try {
			permissionService.update(permission);
			return Result.success("修改成功");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return Result.failure(e.getMessage());
		}
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	@ResponseBody
	public Result delete(@PathVariable Long id) {
		try {
			permissionService.delete(id);
			return Result.success("删除成功");
		} catch (Exception e) {
			// TODO: handle exception
			return Result.failure(e.getMessage());
		}
	}

	@RequestMapping(value = "/getPermission", method = RequestMethod.GET)
	@ResponseBody
	public List<Permission> getPermission() {
		return permissionService.find();
	}

	@RequestMapping("/tree/{roleId}")
	@ResponseBody
	public List<ZtreeView> tree(@PathVariable Long roleId) {
		List<ZtreeView> list = new ArrayList<>();
		List<Long> rolePermissionList = roleService.findPermissionIdsByRoleId(roleId);
		List<Permission> permissionList = permissionService.find();
		if (!permissionList.isEmpty()) {
			for (Permission permission : permissionList) {
				ZtreeView node = new ZtreeView();
				node.setId(permission.getId());
				if (permission.getParentId() != null) {
					node.setpId(permission.getParentId());
				}
				node.setName(permission.getPermissionName());
				if (rolePermissionList.contains(permission.getId())) {
					node.setChecked(true);
				}
				if (permission.getPermissionType().compareTo("2") == 0) {
					node.setOpen(false);
				} else {
					node.setOpen(true);
				}

				list.add(node);
			}
		}
		return list;
	}
	
}
